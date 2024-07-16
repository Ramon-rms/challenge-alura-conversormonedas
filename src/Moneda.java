import java.util.Map;

public record Moneda (String result,
                     String base_code,
                     Map<String, Double> conversion_rates
                     ) {
    public Map<String, Double> conversion_rates() {
        return conversion_rates;
    }

    @Override
    public String base_code() {
        return base_code;
    }

    @Override
    public String result() {
        return result;
    }

        // Getters y setters

        public String getBaseCode() {
            return base_code;
        }


        public Map<String, Double> getConversionRates() {
            return conversion_rates;
        }

    }



