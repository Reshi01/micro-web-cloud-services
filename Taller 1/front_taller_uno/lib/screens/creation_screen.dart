// Create a Form widget.  
import 'package:flutter/material.dart';

class Creation_screen extends StatefulWidget {  
  @override  
  Creation_screenState createState() {  
    return Creation_screenState();  
  }  
}  
// Create a corresponding State class. This class holds data related to the form.  
class Creation_screenState extends State<Creation_screen> {  
  // Create a global key that uniquely identifies the Form widget  
  // and allows validation of the form.  
  final _formKey = GlobalKey<FormState>();  
  
  @override  
  Widget build(BuildContext context) {  
    // Build a Form widget using the _formKey created above.  
    return Form(  
      key: _formKey,  
      child: Column(  
        crossAxisAlignment: CrossAxisAlignment.start,  
        children: <Widget>[  
          TextFormField(  
            decoration: const InputDecoration(  
              icon: const Icon(Icons.person),  
              hintText: 'Nombre',  
              labelText: 'Nombre',  
            ),  
          ),  
          TextFormField(  
            decoration: const InputDecoration(  
              icon: const Icon(Icons.phone),  
              hintText: 'Coordenadas de punto inicial',  
              labelText: 'Inicio',  
            ),  
          ),  
          TextFormField(  
            decoration: const InputDecoration(  
            icon: const Icon(Icons.calendar_today),  
            hintText: 'Coordenadas de punto final',  
            labelText: 'Fin',  
            ),  
           ),  
          new Container(  
              padding: const EdgeInsets.only(left: 150.0, top: 40.0),  
              child: new ElevatedButton(  
                child: const Text('Submit'),  
                  onPressed: null,  
              )),  
        ],  
      ),  
    );  
  }  
}  