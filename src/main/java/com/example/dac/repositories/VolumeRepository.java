/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dac.repositories;

import com.example.dac.models.Volume;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jean
 */
public interface VolumeRepository extends CrudRepository<Volume, Integer> {
    Volume findVolumeById(Integer id);
}
