package thePackmaster.cards.graveyardpack;

import basemod.helpers.CardModifierManager;
import com.evacipated.cardcrawl.mod.stslib.actions.common.MoveCardsAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cardmodifiers.cosmoscommand.PurgeModifier;

import java.util.function.Predicate;

import static thePackmaster.SpireAnniversary5Mod.makeID;


public class GreyBargain
  extends AbstractGraveyardCard
{
  public static final String ID = makeID("GreyBargain");
  
  private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
  private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
  private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
  
  private static final int COST = 0;
  
	public GreyBargain() {
		super(ID, COST, TYPE, RARITY, TARGET);
	}

  public void use(AbstractPlayer p, AbstractMonster m) {
	  if(p.hand.size()>0) {
		  Predicate<AbstractCard> classy = card -> !(card.color.equals(AbstractCard.CardColor.COLORLESS) || card.color.equals(AbstractCard.CardColor.CURSE) || card.type.equals(AbstractCard.CardType.CURSE) || card.type.equals(AbstractCard.CardType.STATUS));
		  AbstractDungeon.actionManager.addToBottom(new MoveCardsAction(p.drawPile, p.exhaustPile, classy, (c) -> c.forEach(card -> { CardModifierManager.addModifier(card, new PurgeModifier()); p.drawPile.removeCard(card); p.drawPile.addToRandomSpot(card); })));
		  AbstractDungeon.actionManager.addToBottom(new ExhaustAction(p,p,1,false));
	  }
	  if(this.upgraded) {
		  AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p,1));
	  }
  }


	public boolean canUse(AbstractPlayer p, AbstractMonster m) {
		boolean canUse = super.canUse(p, m);
		if (!canUse) {
			return false;
		}
		if (p.hand.size()==0 || (p.hand.size()==1 && p.hand.contains(this)) ) {
			canUse = false;
			this.cantUseMessage = cardStrings.EXTENDED_DESCRIPTION[0];
		}

		return canUse;
	}
  
	public void upp() {
	}
}
