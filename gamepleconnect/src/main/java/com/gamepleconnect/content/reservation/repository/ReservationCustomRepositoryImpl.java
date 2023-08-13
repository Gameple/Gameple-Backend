package com.gamepleconnect.content.reservation.repository;

import static com.gamepleconnect.content.reservation.domain.QReservation.reservation;
import com.gamepleconnect.content.reservation.dto.ReservationRequestDto;
import com.gamepleconnect.root.game.domain.Game;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ReservationCustomRepositoryImpl implements ReservationCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public ReservationCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean existsByEmail(String email, Game game) {
        Integer fetchOne = jpaQueryFactory
                .selectOne()
                .from(reservation)
                .where(reservation.game.eq(game))
                .where(reservation.email.eq(email))
                .fetchOne();

        return fetchOne != null;
    }
}
