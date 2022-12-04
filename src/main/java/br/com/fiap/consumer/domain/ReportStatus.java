package br.com.fiap.consumer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Deprecated
@ToString(includeFieldNames = true)
public record ReportStatus(
        @JsonProperty("id") String id,
        @JsonProperty("latitude") double latitude,
        @JsonProperty("longitude") double longitude,
        @JsonProperty("temperatura") int temperatura,
        @JsonProperty("umidade") int umidade
) implements Serializable, Comparable<ReportStatus> {

    @Override
    public int compareTo(ReportStatus o) {
        return o.compareTo(this);
    }

}
