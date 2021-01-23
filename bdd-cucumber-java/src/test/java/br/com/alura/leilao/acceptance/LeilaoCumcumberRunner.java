package br.com.alura.leilao.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // usar junit 4 para rodar junto ao cucumber
@CucumberOptions(features = "classpath:features", tags = "@leilao")
public class LeilaoCumcumberRunner {

}
