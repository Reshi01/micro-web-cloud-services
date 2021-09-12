import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:front_taller_uno/model/paseo.dart';
import 'package:uuid/uuid.dart';

class Api_tours{
  
  Future<List<Paseo>> getPaseos() async {
    final response =
        await http.get(Uri.parse('http://10.0.2.2:8080/myapp/paseos/all'));

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
      print(response.statusCode);
      throw Exception('Hay problemas para conectar con el servidor');
    }
  }

  void modifyPath( String start, String finish, String id) async {
    final body = jsonEncode({
      'cancellationReason': start,
      'cancelledBy': finish,
      
    });

    Map<String, String> headers = {
      'Content-type': 'application/json',
      'Accept': 'application/json',
    };

    final response = await http
        .put(Uri.parse('http://10.0.2.2:8080/myapp/paseos/modify?id=' + id + 
        '&nstartLocation=' + start + '&endLocation=' + finish)
        
        );
    if (response.statusCode != 200) {
      print(response.statusCode);
      throw Exception('Hay problemas para conectar con el servidor');
    }
  }

  void postPaseo(String name, String dateTime, String start, String finish) async {
    final body = jsonEncode({
      'id': Uuid().v1(),
      'name': name,
      'date': dateTime,
      'startLocation': start,
      'endLocation': finish,
      
    });

    Map<String, String> headers = {
      'Content-type': 'application/json',
      'Accept': 'application/json',
    };

    final response = await http.post(Uri.parse('http://10.0.2.2:8080/myapp/paseos/add'),
    headers: headers,
      body: body
    );

    if (response.statusCode != 200) {
      print(response.statusCode);
      throw Exception('Hay problemas para conectar con el servidor');
    }
    print("Solicitud realizada correctamente");
      
  }

  void deletePaseo(String id) async {
    final response =
        await http.delete(Uri.parse('http://10.0.2.2:8080/myapp/paseos/delete?=' + id));

    if (response.statusCode != 200) {
      // If the server did return a 200 OK response,
      throw Exception('Hay problemas para conectar con el servidor');
    }
  }

}