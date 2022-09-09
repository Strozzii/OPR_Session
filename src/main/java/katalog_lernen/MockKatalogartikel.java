package katalog_lernen;

public class MockKatalogartikel extends Katalogartikel{

    private final String text;

    public MockKatalogartikel(String text){
        super(0.0f);
        this.text = text;
    }



    @Override
    public String gibText() {
        return this.gibSuchtext();
    }

    @Override
    protected String gibSuchtext() {
        return text;
    }
}
