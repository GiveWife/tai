package util;

/**
 * Een klassie die uitleg methodes voorlegt zodat uitleg bij een klasse kan geprint worden.
 *
 * Dit is handig voor wanneer het algoritme & de bedenkingen & inzichten achter de berekeningen niet meer duidelijk zijn
 */
public abstract class LeerstofModule {

    private final String naam;

    public LeerstofModule(String naam) {
        this.naam = naam;
    }

    /**
     * De methode die alle informatie voor de leerstofmodule uitprint
     */
    public abstract void uitleg();

    public void print(String s) {

    }

}
