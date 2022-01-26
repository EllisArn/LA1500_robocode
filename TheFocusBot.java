package ArnEllis;
import robocode.*;
import java.util.Random;

public class TheFocusBot extends JuniorRobot
{
	int Start = 0;
	int gunsHeading;
	Random rd;

	public void run() {

		setColors(black, white, green, red, green);
		// Sets these colors (robot parts): body, gun, radar, bullet, scan_arc
		
		while(true) {
			if (Start == 0)
			{
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
			else if (Start == 1)
			{
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

			
		}
	}


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

	public void onHitWall() {

		turnTo(-hitWallBearing);
		Start = 0;
	}	
}