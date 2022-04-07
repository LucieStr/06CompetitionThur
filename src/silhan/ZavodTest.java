
package silhan;

public class ZavodTest {
    public static void main(String[] args) {
        Zavod jizerska = new Zavod("jizerska 50");
        jizerska.addCompetitor("Jakub", "Silhan", 2002, "Muz");
        jizerska.addCompetitor("Ivona", "Silhanova", 1977, "Zena");
        //jizerska.addCompetitors(2);
        jizerska.displayComp();
        //System.out.println(jizerska.getCompetitors()[1].getIdNum());
    }
}
