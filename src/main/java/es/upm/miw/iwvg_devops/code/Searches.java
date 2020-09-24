package es.upm.miw.iwvg_devops.code;

public class Searches {

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isProper)
                .findFirst()
                .orElseThrow(() ->  new RuntimeException("Fraction not found"));
    }
}
