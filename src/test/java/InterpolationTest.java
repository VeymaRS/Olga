import com.weymar87.Interpolation;
import com.weymar87.base.SoilTypes;
import com.weymar87.base.Soils;
import com.weymar87.base.withoutdsal.Pressure;
import org.junit.Assert;
import org.junit.Test;

public class InterpolationTest {
    @Test
    public void linearInterpolationForPressureTest() {
        //given
        Interpolation interpolation = new Interpolation();
        Pressure pressure = new Pressure();
        double T = -0.5;
        double depth = 7;
        Soils soils = new Soils("ИГЭ", SoilTypes.SAND.getCode(),
                00000.00, 0.00, 0.0, 0.0, 0.0, false);

        //when
        double result =
                interpolation.linearInterpolationForPressure(pressure.getArrRWithoutDsalPile(), T, depth, soils);

        // then
        Assert.assertEquals(-1800, result);
    }
}
