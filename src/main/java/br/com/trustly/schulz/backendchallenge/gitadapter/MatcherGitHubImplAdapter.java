package br.com.trustly.schulz.backendchallenge.gitadapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.RepositoryAdapter;
import br.com.trustly.schulz.backendchallenge.utils.FileUtils;

/**
 * 
 * @author vinicius.schulz
 *
 */
public class MatcherGitHubImplAdapter extends RepositoryAdapter {

	private List<String> trees;

	public MatcherGitHubImplAdapter(String gitUrl) {
		super(gitUrl);
		this.trees = new ArrayList<>();
	}

	@Override
	public ListGitDetailDto getListDetails() {
		try {
			readTree(getGitUrl());
			return getDetails();
		} catch (Exception e) {
			throw new RuntimeException("Failed to get information.", e);
		}
	}

	/**
	 * Function to read the github's directory tree
	 * 
	 * @param url github's link
	 * @throws IOException exception throws in erro case
	 */
	private void readTree(String urlGit) {

		try {
			String[] splitedUrl = urlGit.split("https://github.com/")[1].split("/");
			URL url = new URL(urlGit);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			String readStream = readStream(con.getInputStream());
			Matcher blobPattern = Pattern
					.compile("<a class=\\\"js-navigation-open link-gray-dark\\\" title=\\\"[^\\\"]*\\\" href=\\\"\\/"
							+ splitedUrl[0] + "\\/" + splitedUrl[1] + "\\/blob\\/[^\\\"]*\\\">")
					.matcher(readStream);
			while (blobPattern.find()) {
				readBlob("https://github.com" + handleUrl(blobPattern.group()));
			}

			Matcher treePattern = Pattern
					.compile("<a class=\\\"js-navigation-open link-gray-dark\\\" title=\\\"[^\\\"]*\\\" href=\\\"\\/"
							+ splitedUrl[0] + "\\/" + splitedUrl[1] + "\\/tree\\/[^\\\"]*\\\">")
					.matcher(readStream);
			while (treePattern.find()) {
				if (!alreadyNavigated(treePattern.group())) {
					readTree("https://github.com" + handleUrl(treePattern.group()));
				}
			}

		} catch (Exception e) {
			throw new RuntimeException("Fail to read page", e);
		}

	}

	private String readStream(InputStream in) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
			String nextLine = "";
			while ((nextLine = reader.readLine()) != null) {
				sb.append(nextLine);
			}
		} catch (IOException e) {
			throw new RuntimeException("Fail to read page", e);
		}
		return sb.toString();
	}

	/**
	 * Function to read github's file blob
	 * 
	 * @param fName file path
	 * @throws IOException
	 */
	private void readBlob(String fName) throws IOException {
		String userUrl = fName;

		Long size = 0L;
		Integer lines = 0;
		final String extension = FileUtils.getExtension(userUrl);

		if (userUrl.contains("/blob/")) {
			userUrl = userUrl.replace("/blob/", "/raw/");
		}

		InputStreamReader isr = null;
		BufferedReader buffRead = null;
		URL url = new URL(userUrl);
		URLConnection conn = url.openConnection();
		size = (long) conn.getContentLength();
		isr = new InputStreamReader(conn.getInputStream());
		buffRead = new BufferedReader(isr);
		lines = (int) buffRead.lines().count();

		includeGitDetailDto(extension, size, lines);
	}

	private String handleUrl(String url) {
		return url.replaceAll("<a class=\\\"js-navigation-open link-gray-dark\\\" title=\\\"[^\\\"]*\\\" href=\\\"", "")
				.replace("\">", "");
	}

	private Boolean alreadyNavigated(String url) {
		if (trees.contains(url)) {
			return true;
		}
		trees.add(url);
		return false;
	}
}
