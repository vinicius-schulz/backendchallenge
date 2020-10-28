package br.com.trustly.schulz.backendchallenge.gitadapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import br.com.trustly.schulz.backendchallenge.dto.ListGitDetailDto;
import br.com.trustly.schulz.backendchallenge.gitadapter.base.RepositoryAdapter;
import br.com.trustly.schulz.backendchallenge.utils.FileUtils;

/**
 * 
 * @author vinicius.schulz
 *
 */
public class GitHubImplAdapter extends RepositoryAdapter {

	public GitHubImplAdapter(String gitUrl) {
		super(gitUrl);
	}

	@Override
	public ListGitDetailDto getListDetails() {
		try {
			readTree(getGitUrl());
			return getDetails();
		} catch (Exception e) {
			throw new RuntimeException("Failed to git information.", e);
		}
	}

	/**
	 * Function to read the github's directory tree
	 * 
	 * @param url github's link
	 * @throws IOException exception throws in erro case
	 */
	private void readTree(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();

		for (Element div : doc.getElementsByClass("js-active-navigation-container")) {
			for (Element a : div.getElementsByClass("js-navigation-open link-gray-dark")) {
				String hrefContent = a.attr("href");

				if (hrefContent.contains("/tree/")) {
					readTree("https://github.com" + hrefContent);
				}

				if (hrefContent.contains("/blob/")) {
					readBlob("https://github.com" + hrefContent);
				}
			}
		}

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
}
