# Warframe Standing Calculator

Warframe consists of multiple syndicates that could be a hassle to keep track of. This program calculates syndicate related statistics in Warframe. **The calculations will assume that you will always reach standing cap every day**. The user must first select a syndicate to calculate by inputting the number it is linked to. The program will then proceed with the steps enumerated below.

### User Input

* ***Current rank***: Your current rank in the selected syndicate.
* ***Current standing***: Your current standing in the selected syndicate.
* ***Standing resources***: Resources like **Toroids** or **Debt-Bonds** which can be turned in for standing. This is an **optional input** and will only list the most optimal standing resources for that syndicate.

### Program Output

* ***Days to reach max***: Based on the standing cap gain, it only calculates until the user reaches max rank, not when the user reaches max rank and max standing. Also displays total standing required to reach max rank.
* ***Sacrifices needed to reach max rank***: Once hitting the rank standing cap and need to rank up, it requires you to sacrifice resources. This output calculates all your needed sacrifices based on your current rank. Afterwards, it displays a list of every resource and the amount needed to reach max rank from your current rank.
* ***Standing resources total standing and days it can last***: Calculates the total standing from each resource owned and adds up all the total standing from all standing resources. A list these data will be displayed along with how many days it can last when constantly turned in daily to reach standing cap.

### Additional Notes

There will be cases when certain inputs or outputs will not display entirely, and this is mainly due to the selected syndicate not having sacrifices or standing resources. The **Cephalon Simaris** syndicate is not included due to it being simple and **faction syndicates** already have their own calculator at [Tenno Tools](https://tenno.tools/syndicate/).