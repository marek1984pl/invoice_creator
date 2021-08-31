package pl.poligro.invoice_creator.product.application.port

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ProductServiceTest extends Specification {

    @Autowired
    ProductUseCase productService

    def "vat amount calculation test"() {
        given:
        def product = ProductUseCase.AddProductCommand.builder()
                .name("LG 55CX3LA 55 OLED 4K 120Hz WebOS Dolby Atmos HDMI 2.1")
                .shortName("LG 55CX3LA")
                .unit("szt.")
                .grossPrice(new BigDecimal(grossPrice))
                .vat(new BigDecimal(vat))
                .build()

        when:
        def savedProduct = productService.addProduct(product)

        then:
        savedProduct.getVatAmount() == vatAmount

        where:
        vat | grossPrice   || vatAmount
        3   | "1000"       || 29.13
        5   | "1000"       || 47.62
        7   | "1000"       || 65.42
        8   | "1000"       || 74.07
        23  | "1000"       || 186.99
        3   | "2212.21"    || 64.43
        5   | "1.87"       || 0.09
        7   | "111.87"     || 7.32
        8   | "87.57"      || 6.49
        23  | "11.99"      || 2.24
    }

    def "net amount calculation test"() {
        given:
        def product = ProductUseCase.AddProductCommand.builder()
                .name("LG 55CX3LA 55 OLED 4K 120Hz WebOS Dolby Atmos HDMI 2.1")
                .shortName("LG 55CX3LA")
                .unit("szt.")
                .grossPrice(new BigDecimal(grossPrice))
                .vat(new BigDecimal(vat))
                .build()

        when:
        def savedProduct = productService.addProduct(product)

        then:
        savedProduct.getNetPrice() == netPrice

        where:
        vat | grossPrice   || netPrice
        3   | "1000"       || 970.87
        5   | "1000"       || 952.38
        7   | "1000"       || 934.58
        8   | "1000"       || 925.93
        23  | "1000"       || 813.01
        3   | "2212.21"    || 2147.78
        5   | "1.87"       || 1.78
        7   | "111.87"     || 104.55
        8   | "87.57"      || 81.08
        23  | "11.99"      || 9.75
    }

    def "net + vat amount equals gross"() {
        given:
        def product = ProductUseCase.AddProductCommand.builder()
                .name("LG 55CX3LA 55 OLED 4K 120Hz WebOS Dolby Atmos HDMI 2.1")
                .shortName("LG 55CX3LA")
                .unit("szt.")
                .grossPrice(new BigDecimal(grossPrice))
                .vat(new BigDecimal(vat))
                .build()

        when:
        def savedProduct = productService.addProduct(product)

        then:
        savedProduct.getGrossPrice() == savedProduct.getNetPrice() + savedProduct.getVatAmount()

        where:
        vat | grossPrice
        3   | "1000"
        5   | "1000"
        7   | "1000"
        8   | "1000"
        23  | "1000"
        3   | "2212.21"
        5   | "1.87"
        7   | "111.87"
        8   | "87.57"
        23  | "11.99"
    }
}
