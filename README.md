# LA1550_robocode

## Ausgangslage

Wir haben während drei Wochen ein klassenübergreifendes robocode-Turnier veranstaltet. Robocode ist ein Open-Source-Programmierspiel, bei dem virtuelle Roboter auf einem Spielfeld gegeneinander kämpfen. In robocode kann man seinen eigenen Roboter programmieren. Das geht mit Funktionen, die nur ausgeführt werden, wenn eine bestimmte Bedingung erfüllt ist. Z.B: Wenn der Roboter getroffen wird, dann macht der Roboter etwas. Und mit einer Funktion, die jede Runde ausgeführ wird. In dieser Funktion ist normalerweise der Code, der den Roboter bewegt und der Code, der die Umgebung scannt.

## Ziel

Das Ziel dieses Portfolios ist, dem Leser die Strategie meines Roboters zu erklären.

## Roboter

In robocode gibt es drei verschiedene Arten von Robotern. Die JuniorRobots, die auf eine Art "vereinfacht" wurden, die Robots oder auch die "normalen" Roboter und die AdvancedRobots, die sehr kompliziert sind und auch Vorhersagen treffen können.
Wir haben JuniorRobots programmiert, da wir noch nie mit Java und vorallem noch nie mit robocode gearbeitet haben.

### Strategie meines Roboters

Mein Roboter bewegt sich im Normalzustand ziemlich zufällig, damit er nicht so leicht getroffen wird. Wenn er jemanden sieht (scannt), dann geht er in die Kampf-Phase über. In der Kampf-Phase bewegt er sich zwar immernoch etwas zufällig, aber er fokussiert regelrecht den Roboter, den er gescannt hat.

## Verifikation

## Reflexion & VBV

Da die Roboter in Java geschrieben werden und wir normalerweise in C# schreiben, musste ich mich anfangs etwas daran gewöhnen, aber eigentlich ging es ganz gut, da C# und Java relativ ähnlich sind. Die API war etwas sehr hilfreiches. Ohne die API hätte ich wahrscheinlich nicht den Roboter, den ich gemacht habe, machen können. Ich glaube das schwerste war, dass man bei JuniorBots nicht schauen kann, ob der Roboter, den man gerade abschiesst kaputt ist oder ob er noch am leben ist. Da mein Roboter einer ist, der sich immer nur auf einen Gegner fokussiert war das etwas nervig, da sich mein Roboter, wenn er einen Gegner fokussiert, anders bewegt. Wenn er nicht weiss, ob der Gegner noch lebt, dann bewegt er sich weiter in seiner Kampf-Bewegung, was nicht sehr optimal ist. Ich habe es aber geschafft, den Fehler so gut es geht zu beheben, wodurch aber die Zielgenauigkeit gesunken ist.
Beim nächsten Mal, wenn ich etwas mit robocode mache, will ich einen normalen oder einen advanced-robot machen der errät, wie er ausweichen muss und wohin der Gegner fährt, um im Voraus zu zielen.
Ich werde, wenn es eine API gibt, diese am Anfang besser und länger durchlesen, da in der API so viel wichtige Variablen und Funktionen geschrieben sind. Ohne die API hätte ich niemals einen Roboter wie meinen machen können.
