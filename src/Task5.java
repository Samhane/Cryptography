import java.util.ArrayList;

public class Task5 extends CrypthText {
    private int k;
    private int m;
    private int n;

    public Task5(int k, String key, ArrayList<String> source, boolean encode) {
        super(key, source, encode);
        this.k = k;
        this.m = alphabet.length();
        createResultText();
    }

    @Override
    protected void createResultText() {
        for (int i = 2; i <= this.m / 2; i++) {
            if (gcd(i, this.m) == 1) {
                this.n = i;
                break;
            }
        }
        if (this.encode) {
            resultText.add(encode());
        } else {
            resultText.add(decode());
        }
    }

    private String encode() {
        StringBuilder workSecret = new StringBuilder();
        for (int i = 0; i < this.sourceText.length(); i++) {
            int newIndex = (alphabet.indexOf(sourceText.charAt(i)) * this.n + this.k) % this.m;
            workSecret.append(this.alphabet.charAt(newIndex));
        }
        return workSecret.toString();
    }

    private String decode() {
        StringBuilder workSecret = new StringBuilder();
        int reversedN = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if ((this.n * i) % this.m == 1) {
                reversedN = i;
                break;
            }
        }
        for (int i = 0; i < this.sourceText.length(); i++) {
            int currentIndex = this.alphabet.indexOf(sourceText.charAt(i)) - this.k;
            currentIndex = ((currentIndex * reversedN) % this.m + this.m) % this.m;
            workSecret.append(alphabet.charAt(currentIndex));
        }
        return workSecret.toString();
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
