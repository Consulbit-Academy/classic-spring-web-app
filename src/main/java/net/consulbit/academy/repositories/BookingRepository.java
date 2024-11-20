package net.consulbit.academy.repositories;

import net.consulbit.academy.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}