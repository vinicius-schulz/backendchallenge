package br.com.trustly.schulz.backendchallenge.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FileUtilsTest {

	@Test
	public void getExtensionTest() {
		String response = FileUtils.getExtension("application.java");
		assertThat(response).isEqualTo("java");
	}

}
