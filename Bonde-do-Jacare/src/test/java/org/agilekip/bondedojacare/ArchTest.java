package org.agilekip.bondedojacare;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.agilekip.bondedojacare");

        noClasses()
            .that()
            .resideInAnyPackage("org.agilekip.bondedojacare.service..")
            .or()
            .resideInAnyPackage("org.agilekip.bondedojacare.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..org.agilekip.bondedojacare.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
