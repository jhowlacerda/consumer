package br.com.fiap.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
@Data
public class ReportStatus implements Comparable<ReportStatus> {

    private String idDrone;
    private double latitude;
    private double longitude;
    private int temperatura;
    private int umidade;

    @Override
    public int compareTo(ReportStatus o) {
        return o.getIdDrone().compareTo(this.getIdDrone());
    }

}
