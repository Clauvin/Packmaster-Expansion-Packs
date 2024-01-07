package thePackmaster.cards.royaltypack.optioncards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.ThePackmaster;
import thePackmaster.actions.royaltypack.PayTributeAction;
import thePackmaster.cards.royaltypack.AbstractRoyaltyCard;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

@AutoAdd.Ignore
public class MoreSuppliesTribute extends AbstractRoyaltyCard {

    public final static String ID = makeID("MoreSuppliesTribute");

    public MoreSuppliesTribute(int tribute_gold_amount){
        super(ID, -2, CardType.STATUS, CardRarity.SPECIAL, CardTarget.SELF, ThePackmaster.Enums.PACKMASTER_RAINBOW,
                "anniv5Resources/images/cards/OptionTribute.png");
        baseMagicNumber = tribute_gold_amount;
        magicNumber = baseMagicNumber;
    }

    @Override
    public void upp() {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        onChoseThisOption();
    }


    @Override
    public void onChoseThisOption() {
        Wiz.atb(new PayTributeAction(magicNumber));
        for (int i = 0; i < AbstractDungeon.player.potionSlots; i++){
            Wiz.atb(new ObtainPotionAction(AbstractDungeon.returnRandomPotion(false)));
        }
    }
}
