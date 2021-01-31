package com.mycompany.ehealth;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.mycompany.ehealth");

        noClasses()
            .that()
                .resideInAnyPackage("com.mycompany.ehealth.service..")
            .or()
                .resideInAnyPackage("com.mycompany.ehealth.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.mycompany.ehealth.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
