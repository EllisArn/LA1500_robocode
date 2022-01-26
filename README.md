# LA1550_robocode

## Ausgangslage

Wir haben während drei Wochen ein klassenübergreifendes robocode-Turnier veranstaltet. Robocode ist ein Open-Source-Programmierspiel, bei dem virtuelle Roboter auf einem Spielfeld gegeneinander kämpfen. In robocode kann man seinen eigenen Roboter programmieren. Das geht mit Funktionen, die nur ausgeführt werden, wenn eine bestimmte Bedingung erfüllt ist. Z.B: Wenn der Roboter getroffen wird, dann macht der Roboter etwas. Und mit einer Funktion, die jede Runde ausgeführ wird. In dieser Funktion ist normalerweise der Code, der den Roboter bewegt und der Code, der die Umgebung scannt. 
<br>
Im Anhang befindet sich zu einem eine .jar Datei, die man in robocode importieren kann und eine .java Datei, in der einfach nur der Code steht. API: https://robocode.sourceforge.io/docs/robocode/robocode/JuniorRobot.html

## Ziel

Das Ziel dieses Portfolios ist, dem Leser die Strategie meines Roboters zu erklären.

## Roboter

In robocode gibt es drei verschiedene Arten von Robotern. Die JuniorRobots, die auf eine Art "vereinfacht" wurden, die Robots oder auch die "normalen" Roboter und die AdvancedRobots, die sehr kompliziert sind und auch Vorhersagen treffen können.
<br>
Wir haben JuniorRobots programmiert, da wir noch nie mit Java und vorallem noch nie mit robocode gearbeitet haben.

## Strategie meines Roboters

### Phase 1

Am Anfang des Kampfes geht mein Roboter in den Normalzustand. Im Normalzustand dreht sich mein Roboter in eine zufällige Richtung, die ich davor immer neu generiere. Nachdem er das gemacht hat, berechnet er die durchschnittliche Länge der Höhe und der Breite des Spielfelds. Mit dem Durchschnitt berechnet er eine zufällige Zahl zwischen einem Zehntel und einem Drittel des Durchschnitts. Diese Zahl ist dann die Länge der Strecke, die er nach Vorne fährt. Und nachdem er angekommen ist, scannt er einmal seine gesamte 360°-Umgebung. Wenn er gegen eine Wand fährt, dann prallt er sozusagen von der Wand ab. Wenn er jemanden sieht, dann geht er in Phase 2 über. Wenn nicht, dann bleibt er in Phase 1.
<br>
Phase 1:
```java
if (Start == 0) {
	out.println("Just being random");
	gunsHeading = gunHeading;
	rd = new Random();
	int turnAngle = rd.nextInt(1, 360);
	turnTo(turnAngle);
	turnGunTo(gunsHeading);
	int field = (fieldHeight + fieldWidth) / 2;
	int fromField = field / 10;
	int toField = field / 3;
	rd = new Random();
	ahead(rd.nextInt(fromField, toField));
	turnGunTo(gunsHeading);
	turnGunRight(360);
}
```

Wand Abprall:
```java
public void onHitWall() {
	turnTo(-hitWallBearing);
	Start = 0;
}	
```

### Phase 2

In der Phase 2 begibt sich der Roboter in den Kampf- bzw. Fokussiermodus. Er dreht sich nicht mehr, aber er fähr immernoch auf einer zufälligen Strecke, die vorher berechnet wurde, um auszuweichen und um seine Zielgenauigkeit zu verbessern. Also eigentlich fährt er in Schritten nach Vorne und schiesst durchgehend auf den Roboter, den er fokussiert, solange er einen Roboter sieht.

Phase 2:
```java
else if (Start == 1) {
	out.println("Focusing");
	gunsHeading = gunHeading;
	turnGunTo(gunsHeading);
	int field = (fieldHeight + fieldWidth) / 2;
	int fromField = field / 10;
	int toField = field / 3;
	rd = new Random();
	ahead(rd.nextInt(fromField, toField));
	turnGunTo(gunsHeading);
	turnGunRight(360);
}
```

Fokus:
```java
public void onScannedRobot() {
	turnGunTo(scannedAngle);
	Start = 1;
	if (scannedDistance < 400)
	{
		fire(3);
	}
	else
	{
		fire(1);
	}
}
```
Was speziell an meinem Roboter ist, ist seine Rache. sobald mein Roboter getroffen wurde, Schiesst er dorthin zurück, von wo der Schuss kam. Zusätzlich geht er, solange er den Gegner nicht sieht, in die Phase 1 zurück. Das war ziemlich schwer gut zu implementieren und ich habe diesen Code mehrfach komplett umgeschrieben.

Rache:
```java
public void onHitByBullet() {
	int angle = hitByBulletAngle;
	if (scannedDistance < 400)
	{
		turnGunTo(angle);
		fire(3);
	}
	else
	{
		turnGunTo(angle);
		fire(1);
	}
	Start = 0;
}
```

### Video

Ich habe in Video einen Gegner genommen, der auf seinen gegner zustürmt und erst ernn er d^seinen Gegner trifft, schiesst.
<br>
Mein Roboter ist der Schwarze.

https://user-images.githubusercontent.com/89130718/151145824-380374b2-51cf-4eb4-8643-810a3e6ce037.mp4

## Verifikation

Ich habe mein Portfolio einem Klassenkameraden gezeigt und er hat mir gesagt, dass er die Strategie meines Roboters verstanden hat.

## Reflexion & VBV

Da die Roboter in Java geschrieben werden und wir normalerweise in C# schreiben, musste ich mich anfangs etwas daran gewöhnen, aber eigentlich ging es ganz gut, da C# und Java relativ ähnlich sind. Die API war etwas sehr hilfreiches. Ohne die API hätte ich wahrscheinlich nicht den Roboter, den ich gemacht habe, machen können. Ich glaube das schwerste war, dass man bei JuniorBots nicht schauen kann, ob der Roboter, den man gerade abschiesst kaputt ist oder ob er noch am leben ist. Da mein Roboter einer ist, der sich immer nur auf einen Gegner fokussiert war das etwas nervig, da sich mein Roboter, wenn er einen Gegner fokussiert, anders bewegt. Wenn er nicht weiss, ob der Gegner noch lebt, dann bewegt er sich weiter in seiner Kampf-Bewegung, was nicht sehr optimal ist. Ich habe es aber geschafft, den Fehler so gut es geht zu beheben, wodurch aber die Zielgenauigkeit gesunken ist. 
<br>
Es war ebenfalls schwer, den Roboter genau dorthin zurückschiessen zu lassen, von wo er getroffen wurde. Diesen Fehler habe ich aber nach ein paar mal umschreiben ebenfalls behoben.

Beim nächsten Mal, wenn ich etwas mit robocode mache, will ich einen normalen oder einen advanced-robot machen der errät, wie er ausweichen muss und wohin der Gegner fährt, um im Voraus zu zielen.
<br>
Ich werde beim nächsten Mal, egal bei welchem Thema, wenn es eine API gibt, diese am Anfang besser und länger durchlesen, da in der API so viel wichtige Variablen und Funktionen geschrieben sind. Ohne die API hätte ich niemals einen Roboter wie meinen machen können.
