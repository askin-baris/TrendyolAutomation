Feature: Trendyol sitesine Login olma ve ürün aratma
  işlem adımlarının yürütüldüğü otomasyonudur.

  Scenario: Login ve ürün aratma işlemi
    Given trendyol yüklenir
    When giriş yap ikonuna tıklanır
    Then eposta adresi girilir
    And ürün araması yapılır
    And ürüne tıklanır
    And ürün numarası seçilir "41"
   ## And ürün listeleme ekranına geri dönülür