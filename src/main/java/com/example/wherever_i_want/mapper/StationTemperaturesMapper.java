package com.example.wherever_i_want.mapper;

import com.example.wherever_i_want.domain.StationTemperatures;
import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import org.springframework.stereotype.Component;

@Component
public class StationTemperaturesMapper {

    public StationTemperatures mapMeteostatStationTemperaturesDtoToStationTemperatures(final String cityId, final MeteostatStationTemperaturesDto meteostatStationTemperaturesDto) {
        StationTemperatures stationTemperatures = new StationTemperatures();
        stationTemperatures.setCityId(cityId);

           if (meteostatStationTemperaturesDto.getDataDto() != null) {

               stationTemperatures.setJANUARY(meteostatStationTemperaturesDto.getDataDto().getTemperature().getJAN());
               stationTemperatures.setFEBRUARY((meteostatStationTemperaturesDto.getDataDto().getTemperature().getFEB()));
               stationTemperatures.setMARCH(meteostatStationTemperaturesDto.getDataDto().getTemperature().getMAR());
               stationTemperatures.setAPRIL(meteostatStationTemperaturesDto.getDataDto().getTemperature().getAPR());
               stationTemperatures.setMAY(meteostatStationTemperaturesDto.getDataDto().getTemperature().getMAY());
               stationTemperatures.setJUNE(meteostatStationTemperaturesDto.getDataDto().getTemperature().getJUN());
               stationTemperatures.setJULY(meteostatStationTemperaturesDto.getDataDto().getTemperature().getJUL());
               stationTemperatures.setAUGUST(meteostatStationTemperaturesDto.getDataDto().getTemperature().getAUG());
               stationTemperatures.setSEPTEMBER(meteostatStationTemperaturesDto.getDataDto().getTemperature().getSEP());
               stationTemperatures.setOCTOBER(meteostatStationTemperaturesDto.getDataDto().getTemperature().getOCT());
               stationTemperatures.setNOVEMBER(meteostatStationTemperaturesDto.getDataDto().getTemperature().getNOV());
               stationTemperatures.setDECEMBER(meteostatStationTemperaturesDto.getDataDto().getTemperature().getDEC());

               return stationTemperatures;
           } else {
               stationTemperatures.setJANUARY(null);
               stationTemperatures.setFEBRUARY(null);
               stationTemperatures.setMARCH(null);
               stationTemperatures.setAPRIL(null);
               stationTemperatures.setMAY(null);
               stationTemperatures.setJUNE(null);
               stationTemperatures.setJULY(null);
               stationTemperatures.setAUGUST(null);
               stationTemperatures.setSEPTEMBER(null);
               stationTemperatures.setOCTOBER(null);
               stationTemperatures.setNOVEMBER(null);
               stationTemperatures.setDECEMBER(null);
               return stationTemperatures;
           }
    }
}
