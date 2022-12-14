Direktiv för uppgift

Du har i uppgift att bygga en bankautomat, men du har inte tillgång till banken. Du får helt enkelt
använda Mockito för att mocka banken för denna uppgift. Utveckla med Test Driven Development.
1. När en användare använder automaten kommer de att sätta in ett kort. Använd ID-numret på
kortet för att hämta en användare från banken.
2. Härnäst skall användaren skriva in ett pin-nummer. Om pin-numret stämmer skall de få
logga in.
3. Om pin-numret är fel så hämta hur många gånger de har fått fel från banken. Om det är
totalt 3 så lås kortet. Om det är färre än 3, meddela användaren om hur många gånger till de
kan försöka och spara antal fel +1 till den mockade banken.
4. Lägg till en check när man först sätter in kortet som kollar med banken om kortet är låst.
Om det är det så kan användaren inte komma in.
5. Om de kommer in skall de ha tre val. Kolla mängd pengar, hämta ut pengar och sätt in
pengar. Om de kollar mängden pengar, hämta hur mycket de har från banken.
6. Om de sätter in pengar i banken så tas ett antal pengar som de sätter in och kalla en funktion
i banken om att sätta in pengarna. Använd verify för att bekräfta att funktionen för att sätta
in pengarna körs.
7. Om de hämtar ut pengar så tas hur mycket pengar de vill ta ut. Hämta hur mycket pengar de
har från banken. Om det är tillräckligt mycket skall pengarna ges tillbaka. Använd verify för
att bekräfta att funktionen körs.
8. Om det inte är tillräckligt med pengar skall de istället få ett meddelande som säger att det
inte finns så mycket pengar i banken.
9. Användaren skall sedan kunna avsluta processen.
10. Bank-automaten skall ha en funktion som bekräftar vilken bank den är kopplad till. Detta
kallar en statisk funktion i vår mockade bank som ger ett meddelande om vilken bank det är.
Se till att denna funkar. Fjärde lektionen bör innehålla det som behövs för att mocka statiska
funktioner.
