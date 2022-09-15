package com.submission.yugioh.model

object CardLocalData {
    private val cardNames = listOf(
        "3-Hump Lacooda",
        "8-Claws Scorpion",
        "A Man with Wdjat",
        "A-Team: Trap Disposal Unit",
        "Photon Deceleration",
        "Numeron Creation",
        "Everton",
        "Fulham FC",
        "Leeds United",
        "Leicester City",
    )

    private val cardType = listOf(
        "Effect Monster",
        "Effect Monster",
        "Effect Monster",
        "Effect Monster,
        "Trap Card",
        "Spell Card",
        "Everton",
        "Fulham FC",
        "Leeds United",
        "Leicester City",
    )

    private val cardLevel = listOf(
        3,
        2,
        4,
        2,
        null,
        null,
        "Everton",
        "Fulham FC",
        "Leeds United",
        "Leicester City",
    )

    private val cardATK = listOf(
        500,
        300,
        1600,
        300,
        null,
        null,
        "Everton",
        "Fulham FC",
        "Leeds United",
        "Leicester City",
    )

    private val cardDEF = listOf(
        1500,
        200,
        1600,
        400,
        null,
        null,
        "Everton",
        "Fulham FC",
        "Leeds United",
        "Leicester City",
    )

    private val cardDesc = listOf(
        "If there are 3 face-up \"3-Hump Lacooda\" cards on your side of the field, Tribute 2 of them to draw 3 cards.",
        "Once per turn, you can flip this card into face-down Defense Position. When this card attacks an opponent's face-down Defense Position monster, this card's ATK becomes 2400 during damage calculation only.",
        "When you Normal Summon this card, and during each of your Standby Phases, select 1 Set card on your opponent's side of the field. Pick it up and look at it, then return it to its original position.",
        "This effect can be used during either player's turn. When your opponent activates a Trap Card, Tribute this face-up card to negate the activation of the Trap Card and destroy it.",
        "Take 1 \"Photon\" or \"Galaxy\" Continuous Spell/Trap from your Deck, and either add it to your hand or place it face-up on your field. If this Set card in its owner's control is destroyed by an opponent's card effect during their turn, and you control \"Galaxy-Eyes Photon Dragon\" or an Xyz Monster that has it as material: You can make it become the End Phase.",
        "(This card is always treated as a \"Galaxy-Eyes\" card.)\r\nIf 3 or more LIGHT Dragon monsters with 3000 or more original ATK are on the field: Special Summon 1 Dragon \"Number\" Xyz Monster from your Extra Deck, then attach this card on the field to it as material. You can only apply this effect of \"Numeron Creation\" once per turn.",
        "Everton",
        "Fulham FC",
        "Leeds United",
        "Leicester City",
    )
}