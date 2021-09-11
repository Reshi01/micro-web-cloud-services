import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:front_taller_uno/model/paseo.dart';

class Api_tours{
  
  Future<List<Paseo>> getPaseos() async {
    final response =
        await http.get(Uri.parse('paseos'));

    if (response.statusCode == 200) {
      // If the server did return a 200 OK response,
      // then parse the JSON as a list of courses.
      print(json.decode(response.body));
      var res = (json.decode(response.body) as List)
          .map((data) => Paseo.fromJson(data))
          .toList();
      res.sort((a, b) => a.name.compareTo(b.name));
      return res;
      //return List<Course>.fromJson(jsonDecode(response.body));
    }else {
      // If the server did not return a 200 OK response,
      // then throw an exception.
      throw Exception('Hay problemas para conectar con el servidor');
    }
  }

  void modifyPath( int start, int finish) async {

  }

  void postPaseo() async {

  }

  void deletePaseo(int id) async {
    
  }

}