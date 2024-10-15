import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class Lesson4Test {
    @BeforeAll
    static void before() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
    }

    @Test
    void checkJUnit5OnWikiPage() {
        open("https://github.com/selenide/selenide");
        $("a#wiki-tab").click();
        $("ul[data-filterable-for='wiki-pages-filter'] li.Box-row.wiki-more-pages-link button").shouldBe(Condition.visible).click();
        $$("a.Truncate-text.text-bold.py-1").findBy(Condition.text("SoftAssertions")).shouldBe(Condition.visible).click();
        $("#wiki-content").shouldHave(Condition.text("Using JUnit5 extend test class"));
    }
}
