# Virgosol - Amazon Test Otomasyon Projesi

Bu projede Virgosol tarafından verilen case oluşturulmuş olup senaryoların POM kullanılarak koşulması sağlanmıştır. 

Proje Özellikleri
--- 
- Java & Selenium frameworkü ile geliştirilmiştir. Mimaride POM(Page Object Model) kullanılmıştır.   
- Annotasyonlar ve assertionlar için JUnit kütüphanesi kullanılmıştır.
- Test sonuçlarının raporlanması adına Log4j kullanılmıştır. Adımlar logs klasöründeki log4j-application.log dosyasından adımlar izlenebilir.
- Testlerin monitoring edilebilmesi için allure report kullanılmıştır.
- Test'in fail olma durumuna karşın ekran görüntüsü kaydetmektedir. Allure report içerisinde hata adımı ve ekran görüntüsü gözlemlenebilir.
- WebDriverManager kullanılmıştır. Böylelikle her browser için farklı bir driver indirmemek ve aksini belirtmedikçe driverın son versiyonunu indirmesi için.


Task
---
- https://www.amazon.com.tr/ sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir.
- Çerez tercihlerinden Çerezleri kabul et seçilir.
- Siteye login olunur.
- Login işlemi kontrol edilir.
- Hesabım bölümünden “Virgosol Liste” isimli yeni bir liste oluşturulur.
- Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
- Bilgisayar kategorisi seçildiği kontrol edilir.
- Arama alanına msi yazılır ve arama yapılır.
- Arama yapıldığı kontrol edilir.
- Arama sonuçları sayfasından 2. sayfa açılır.
- İkinci sayfanın açıldığı kontrol edilir.
- Sayfadaki 2. ürün oluşturulan “Virgosol Liste” listesine eklenir.
- İkinci Ürünün listeye eklendiği kontrol edilir.
- Hesabım > Alışveriş Listesi sayfasına gidilir.
- "Alışveriş Listesi" sayfası açıldığı kontrol edilir.
- Eklenen ürün Virgosol Liste’sinden silinir.
- Silme işleminin gerçekleştiği kontrol edilir.
- Üye çıkış işlemi yapılır.
- Çıkış işleminin yapıldığı kontrol edilir.

## 👨🏿‍💻 Senaryo

```cucumber
Feature: Amazon UI Test

  @positive
  Scenario Outline: Virgosol Case Study
    Given I visit "https://www.amazon.com.tr/"
    And   I check that the home page is opened
    And   I choose Accept Cookies from the cookie preferences
    And   I login with "<email>" and "<password>"
    And   I check that successfully login
    And   I am creating a new list called "<listName>" from the My Account section
    And   I choose "<category>" from the categories field next to the search button
    And   I checking that the "<category>" category is selected
    And   I type "<searchKeyword>" in the search field and click the search button
    And   I checking that "<searchKeyword>" successfully listed
    And   I open the "<pageNumber>" page from the search results page
    And   I check that page "<pageNumber>" is opened from the search results page
    And   I add the "<productNumber>" product on the page to the created "<listName>" list
    And   I checking if the product has been added to the list
    And   I go to the "<listName>" page
    And   I check that the "<listName>" page opens
    And   I remove the added product from the "<listName>"
    And   I check if the product has been deleted from the list
    When  I logout of account
    Then  I check that the logout was successful

    Examples:
      | email                         | password    | listName      | category      | searchKeyword | pageNumber | productNumber |
      | virgosolcasestudy@outlook.com | virgosol123 | Virgosol List | Bilgisayarlar | msi           | 2          | 2             |
```

