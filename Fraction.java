public class Fraction {

        private int numerator;
        private int denominator;

        public Fraction (int num, int den){
            this.numerator = num;
            this.denominator = den;
            this.signOperator();
        }

        public Fraction (int num){
            this.numerator = num;
            this.denominator = 1;
            this.signOperator();
        }

        public Fraction (){
            this.numerator = 0;
            this.denominator = 1;
        }

        public void signOperator()  {
            if (numerator < 0 && denominator < 0) {
                this.numerator = Math.abs(numerator);
                this.denominator = Math.abs(denominator);
            } else if (numerator < 0 || denominator < 0) {
                this.numerator = -(Math.abs(numerator));
                this.denominator = Math.abs(denominator);
            } else if (this.denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero!");
            }
        }


        public int getNumerator(){
            return this.numerator;
        }

        public int getDenominator(){
            return this.denominator;
        }

        public String toString(){
            String fractionString;
            if(this.denominator == this.numerator && this.denominator != 1){
                fractionString = String.valueOf(1);
            } else if (this.denominator == 1) {
                fractionString = String.valueOf(this.numerator);
            } else {
                fractionString = this.numerator + "/" + this.denominator;
            }
            return fractionString;
        }

        public double toDouble(){
            double numDouble = (double)numerator;
            double denDouble = (double)denominator;
            double result = numDouble/denDouble;
            return result;
        }

        public Fraction add(Fraction other){
            int newNum = this.numerator * other.denominator + this.denominator * other.numerator;
            int newDen = this.denominator * other.denominator;
            Fraction newF = new Fraction(newNum, newDen);
            return (newF);
        }

        public Fraction subtract(Fraction other){
            int newNum = this.numerator * other.denominator - this.denominator * other.numerator;
            int newDen = this.denominator * other.denominator;
            Fraction newF = new Fraction(newNum, newDen);
            newF.signOperator();
            return (newF);
        }

        public Fraction multiply(Fraction other){
            int newNum = this.numerator * other.numerator;
            int newDen = this.denominator * other.denominator;
            Fraction newF = new Fraction(newNum, newDen);
            newF.signOperator();
            return (newF);
        }

        public Fraction divide (Fraction other){
            int newNum = this.numerator * other.denominator;
            int newDen = this.denominator * other.numerator;
            Fraction newF = new Fraction(newNum, newDen);
            newF.signOperator();
            return (newF);
        }

        public boolean equals(Fraction other){
            double a = this.toDouble();
            double b = other.toDouble();
            boolean ifEqual = (a == b);
            return ifEqual;
        }

        // this is different from the video instructions.
        public Fraction toLowestTerm(){
            int factor = gcd(this.numerator, this.denominator);
            int newNum = this.numerator / factor;
            int newDen = this.denominator / factor;
            Fraction newF = new Fraction(newNum, newDen);
            return newF;
        }

        public int gcd(int num, int den){
            if(den ==0){
                return num;
            }
            return gcd(den, num%den);
        }
}
