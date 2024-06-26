package thePackmaster.cards.downfallpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;

public class DefensiveMode extends AbstractDownfallCard {
    public final static String ID = makeID("DefensiveMode");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    private static final int BLOCK = 20;

    public DefensiveMode() {
        super(ID, 2, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = BLOCK;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToSelf(new WeakPower(p, magicNumber, false));

    }

    public void upp() {
        upgradeMagicNumber(-1);
    }
}