package dinhnguyen.techs.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dinhnguyen.techs.soap.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	@Query("SELECT country FROM Country country WHERE country.name = :name")
	public Country getCountyByName(@Param("name") String name);

}
