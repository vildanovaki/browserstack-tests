package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Successful open tab to hidden card")
    void openTab() {
        step("Open menu", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_list_card_header_menu")).click();
        });

        step("Open tab", () -> {
            assertEquals("Hide this card", $(MobileBy.id("org.wikipedia.alpha:id/title")).getText());
        });
    }
}

//org.wikipedia.alpha:id/view_list_card_header_menu
//        org.wikipedia.alpha:id/title
//        org.wikipedia.alpha:id/view_card_header_title Trending