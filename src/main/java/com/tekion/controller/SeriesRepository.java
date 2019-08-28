package com.tekion.controller;

import com.tekion.beans.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {

    @Query(value = "select * from series where series_id = ?1", nativeQuery = true)
    Series getBySeriesId(int seriesId);
}
