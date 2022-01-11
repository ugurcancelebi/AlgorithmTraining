package com.company.DesignPatterns.Java;

abstract class Activity {
    BillingCalculator calculator1;

    Activity(BillingCalculator calculate)
    {
        this.calculator1 = calculate;
    }

    abstract public void manufacture();
}
class Redemption extends Activity {
    Redemption(BillingCalculator workShop1)
    {
        super(workShop1);
    }
    @Override
    public void manufacture()
    {
        System.out.print("Redemption ");
        calculator1.calculate();
    }
}
class Exchange extends Activity {
    Exchange(BillingCalculator calculator)
    {
        super(calculator);
    }

    @Override
    public void manufacture()
    {
        System.out.print("Exchange ");
        calculator1.calculate();
    }
}

interface BillingCalculator
{
    void calculate();
}

class RevB implements BillingCalculator {
    @Override
    public void calculate()
    {
        System.out.print(" REV. \n");
    }
}

class RBB implements BillingCalculator {
    @Override
    public void calculate()
    {
        System.out.println(" RBB. \n");
    }
}
class BridgePattern {
    public static void main(String[] args)
    {
        Activity activity1 = new Redemption(new RevB());
        activity1.manufacture();
        Activity activity2 = new Exchange(new RBB());
        activity2.manufacture();
    }
} 