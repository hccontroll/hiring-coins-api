package com.hiringcoders.infrastructure.repository.specification;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.hiringcoders.domain.filter.ClientFilter;
import com.hiringcoders.domain.model.Client;
import com.hiringcoders.domain.model.Client_;

public class ClientSpecification {

	public static Specification<Client> usingFilter(ClientFilter filter) {
		return (root, query, builder) -> {

			var predicates = new ArrayList<Predicate>();

			if (StringUtils.hasText(filter.getUuid())) {
				predicates.add(builder.equal(root.get(Client_.uuid), filter.getUuid()));
			}

			if (StringUtils.hasText(filter.getName())) {
				predicates.add(builder.equal(builder.lower(root.get(Client_.name)), filter.getName().toLowerCase()));
			}

			if (StringUtils.hasText(filter.getEmail())) {
				predicates.add(builder.equal(builder.lower(root.get(Client_.email)), filter.getEmail().toLowerCase()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}

}
