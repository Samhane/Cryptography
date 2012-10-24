import java.util.ArrayList;

public class Task5 extends CrypthText {
    private int k;
    private String alphavetB;
    private int m;
    private int n;

    public Task5(int k, String key, ArrayList<String> source, boolean encode) {
        this.k = k;
        this.encode = encode;
        this.resultText = new ArrayList<String>();
        generateAlphavet();
        this.m = alphabet.length();
        StringBuilder tmp = new StringBuilder();
        for (String currentSource : source) {
            tmp.append(currentSource.trim());
        }
        this.sourceText = tmp.toString();
        createResultText();
    }

    @Override
    protected void createResultText() {
        for (int i = 1; i <= this.m / 2; i++) {
            if (gcd(i, this.m) == 1) {
                this.n = i;
                break;
            }
        }
        createAlphavetB();
        StringBuilder workSecret = new StringBuilder();
        if (this.encode) {
            for (int i = 0; i < this.sourceText.length(); i++) {
                workSecret.append(this.alphavetB.charAt(this.alphabet.indexOf(this.sourceText.charAt(i))));
            }
        } else {
            for (int i = 0; i < this.sourceText.length(); i++) {
                workSecret.append(this.alphabet.charAt(this.alphavetB.indexOf(this.sourceText.charAt(i))));
            }
        }
        resultText.add(workSecret.toString());
    }

    private void createAlphavetB() {
        char[] tmp = alphabet.toCharArray();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            int current = ((int) tmp[i]) * this.n + this.k % this.m;
            b.append((char) current);
        }
        this.alphavetB = b.toString();
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
