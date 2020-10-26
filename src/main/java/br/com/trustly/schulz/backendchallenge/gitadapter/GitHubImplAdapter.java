package br.com.trustly.schulz.backendchallenge.gitadapter;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.dfs.DfsRepositoryDescription;
import org.eclipse.jgit.internal.storage.dfs.InMemoryRepository;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;

import br.com.trustly.schulz.backendchallenge.gitadapter.base.GitAdapter;

public class GitHubImplAdapter extends GitAdapter {

	public GitHubImplAdapter(String gitUrl, String branch) {
		super(gitUrl, branch);
	}

	public String getLastCommitId() {

		try {
			loadFromGit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		RevCommit youngestCommit = null;
//		Git git = new Git(new Repo);
//		List<Ref> branches = git.branchList().setListMode(ListMode.ALL).call();
//		try {
//			RevWalk walk = new RevWalk(git.getRepository());
//			for (Ref branch : branches) {
//				RevCommit commit = walk.parseCommit(branch.getObjectId());
//				if (youngestCommit == null
//						|| commit.getAuthorIdent().getWhen().compareTo(youngestCommit.getAuthorIdent().getWhen()) > 0)
//					youngestCommit = commit;
//			}
//		} catch (Exception ex) {
//
//		}

		return "123456789";
	}

	private void loadFromGit() throws Exception {
		ObjectLoader loader = loadRemote(getGitUrl(), "main", "README.md");
		loader.copyTo(System.out);
	}

	private ObjectLoader loadRemote(String uri, String branch, String filename) throws Exception {
		DfsRepositoryDescription repoDesc = new DfsRepositoryDescription();
		InMemoryRepository repo = new InMemoryRepository(repoDesc);
		Git git = new Git(repo);

		RemoteAddCommand remoteAddCommand = git.remoteAdd();
		remoteAddCommand.setName("origin");
		remoteAddCommand.setUri(new URIish(getGitUrl()));
		remoteAddCommand.call();

		git.fetch().call();

		// repo.getObjectDatabase();
		ObjectId lastCommitId = repo.resolve("refs/heads/" + branch);
		RevWalk revWalk = new RevWalk(repo);
		RevCommit commit = revWalk.parseCommit(lastCommitId);
		RevTree tree = commit.getTree();
		TreeWalk treeWalk = new TreeWalk(repo);
		treeWalk.addTree(tree);
		treeWalk.setRecursive(true);
		treeWalk.setFilter(PathFilter.create(filename));
		if (!treeWalk.next()) {
			return null;
		}
		ObjectId objectId = treeWalk.getObjectId(0);
		ObjectLoader loader = repo.open(objectId);
		return loader;
	}

	

}
