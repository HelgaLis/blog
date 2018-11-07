package util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericMultifunctionalMapper<T> {
	private  final  Function<List<Function<T,T>>, Function<List<T>,List<T>>> genericMultifunctionalMapper = 
			functionsList -> valuesList->{
				Function<T,T> func = functionsList.stream().reduce((u1,u2)->u1.andThen(u2)).orElse(x->x);
				Stream<T> valuesStream = valuesList.stream();
				return valuesStream.map(val-> func.apply(val)).collect(Collectors.toList());
			};
	public  List<T> genericTransfromations(List<Function<T, T>> transformationsList, List<T> inputValue){
		return genericMultifunctionalMapper.apply(transformationsList).apply(inputValue);
	}
	//IntFunction<IntFunction<IntFunction<Integer>>> 
	public static void main(String[] args) {
		GenericMultifunctionalMapper<String> gmp = new GenericMultifunctionalMapper<>();
		List<String> inStrAray = Arrays.asList("bom","com","som");
		List<Function<String, String>> transformations = Arrays.asList(String::toUpperCase,s->s.substring(1));
		
		System.out.println(inStrAray);
		System.out.println(gmp.genericTransfromations(transformations, inStrAray));
		
		

	}

}
