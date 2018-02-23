package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import me.joshlin.a3565lib.enums.Alliance;
import me.joshlin.a3565lib.enums.Direction;
import me.joshlin.a3565lib.enums.Location;

/**
 * @author Josh
 */

@Autonomous(name = "Auto Blue Perpendicular", group = "Auto")
public class AutoPerpendicularBlue extends Auto {
    @Override
    public void runOpMode() throws InterruptedException {
        //=================================[Initialization]=======================================
        init(Alliance.BLUE, Location.PERPENDICULAR);
        //===================================[Read VuMark]==========================================
        readVuMark();

        waitForStart();
        //===================================[Run program]==========================================
        status = Status.RUNNING;

        runtime.reset();

        buildTelemetry();
        //===================================[Knock Jewel]==========================================
        knockJewel();
        buildTelemetry();
        //=============================[Align to read Cryptobox]====================================
        // Align horizontally with the cryptobox
        drivetrain.drive(Direction.FORWARD, 1, 1250);
        drivetrain.drive(Direction.LEFT, 1, 700);

        // Make sure we're aligned properly
        correctTurn(0);

        //=============================[Line up with column]========================================
        alignWithCryptobox();

        //=============================[Put Glyph in Cryptobox]=====================================
        correctTurn(-88);
        putGlyphInCryptobox();

        robot.beep();

    }

}
