package manifold.science;

import manifold.science.api.AbstractMeasure;
import manifold.science.util.Rational;

/**
 * Models a measure of temperature in units of {@link TemperatureUnit}.
 * <p/>
 * Use values of {@code Temperature} directly in arithmetic expressions with other dimensions such as:
 * <pre><code>
 *   // commonly used unit abbreviations e.g., m, ft, hr, dC, etc.
 *   import static manifold.science.util.UnitConstants.*;
 *   // rational coercion
 *   import static manifold.science.util.CoercionConstants.r;
 *   ...
 *   Temperature body = 98.6 dF;
 *   Temperature quiteWarm = 98.6 dF + 5 dC;
 *   HeatCapacity kBoltzmann = 1.380649e-23r J/dK;
 * </code></pre>
 */
public final class Temperature extends AbstractMeasure<TemperatureUnit, Temperature>
{
  public Temperature( Rational value, TemperatureUnit unit, TemperatureUnit displayUnit )
  {
    super( value, unit, displayUnit );
  }

  public Temperature( Rational value, TemperatureUnit unit )
  {
    this( value, unit, unit );
  }

  @Override
  public TemperatureUnit getBaseUnit()
  {
    return TemperatureUnit.BASE;
  }

  @Override
  public Temperature make( Rational value, TemperatureUnit unit, TemperatureUnit displayUnit )
  {
    return new Temperature( value, unit, displayUnit );
  }

  @Override
  public Temperature make( Rational value, TemperatureUnit unit )
  {
    return new Temperature( value, unit );
  }

  public Energy times( HeatCapacity c )
  {
    return new Energy( toBaseNumber() * c.toBaseNumber(), EnergyUnit.BASE, c.getDisplayUnit().getEnergyUnit() );
  }
}
