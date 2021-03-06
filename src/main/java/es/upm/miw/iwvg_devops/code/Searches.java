package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isProper)
                .findFirst()
                .orElseThrow(() ->  new RuntimeException("Fraction not found"));
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isImproper)
                .map(Fraction::decimal);
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions()
                    .stream()
                    .anyMatch(Fraction::isImproper))
                .map(User::getName);
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::divide)
                .orElseThrow(() -> new RuntimeException("User without fractions"));
    }
}
