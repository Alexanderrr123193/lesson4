import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

class Lesson4Test {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com/selenide";
    }

    @Test
    void testJUnit5OnWikiPage() {
        open("/selenide");
        $("#wiki-tab").click();
        $("ul[data-filterable-for='wiki-pages-filter'] li.Box-row.wiki-more-pages-link button").shouldBe(Condition.visible).click();
        $$("a.Truncate-text.text-bold.py-1").findBy(Condition.text("SoftAssertions")).shouldBe(Condition.visible).click();
        $("#wiki-content").shouldHave(Condition.text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"
        ));
    }
}
