import java.util.*;
import dayfive.streams.*;
import dayfive.streams.dao.*;
import static java.util.stream.Collectors.toList;
class Main{
	public static void main(String args[]){
		InMemoryWorldDao worldDao=	InMemoryWorldDao.getInstance();
		Set<String> allContinents=worldDao.getContinents();
		List<Country> countries=worldDao.findAllCountries();
		List<City> cities = worldDao.findAllCities();
		highestPopulationInCont();
	}
	//highest populated city in each country
	public static void highestPopulation(List<Country> allCountries){
		InMemoryWorldDao worldDao=InMemoryWorldDao.getInstance();
		allCountries.stream().forEach(country->{
			//get city with max population in each country
			Optional<City> maxPopCity=worldDao.findCitiesByCountryCode(country.getCode()).stream().max(Comparator.comparingInt(City::getPopulation));
			if(maxPopCity.isPresent())
				System.out.println(maxPopCity.get().getName());
			else
				System.out.println("no city");
		});
	}
	//the most populated city in each continent
	public static void highestPopulationInCont(){
		InMemoryWorldDao worldDao=InMemoryWorldDao.getInstance();
		Set<String> allContinents=worldDao.getContinents();
		//map continents to list of countries
		//map each country in list of countries to max population city in this country
		//map the list of countries with the max population city from prev step
		System.out.println(
		allContinents.stream().map(c -> worldDao.findCountriesByContinent(c)).collect(toList()).stream().map(list->{
			Optional<City> temp=list.stream().map(country->{
				Optional<City> maxPopCity=worldDao.findCitiesByCountryCode(country.getCode()).stream().max(Comparator.comparingInt(City::getPopulation));
				if(maxPopCity.isPresent())
					return maxPopCity.get();
				else
					return null;
			}).collect(toList()).stream().filter(cc->cc!=null).max(Comparator.comparingInt(City::getPopulation));
			if(temp.isPresent())
					return temp.get();
				else
					return null;}
		).filter(x->x!=null).map(c->c.getName()).collect(toList()));
	}
	//highest populated capital city
	public static void highestPopulatedCapital(List<Country> allCountries){
		InMemoryWorldDao worldDao=InMemoryWorldDao.getInstance();
		System.out.println(allCountries.size());
		List<City>cities=allCountries.stream().map((c)->worldDao.findCityById(c.getCapital())).collect(toList());
		System.out.println(cities.size());
		Optional<City> city=cities.stream().filter(c->c!=null).max(Comparator.comparingInt(City::getPopulation));
		if(city.isPresent())
			System.out.println(city.get().getName());
		else
			System.out.println("no city");
	}
}