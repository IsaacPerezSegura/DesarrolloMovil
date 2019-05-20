<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Propietario;

class PropietarioController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
		$propietario = new Propietario;
		$propietario->nombre = $request->nombre;
		$propietario->save();
		return "1";
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
		if($id == 'all'){
			return response()->json(Propietario::get());
		}else{
			$propietario = Propietario::find($id);
			if(!$propietario)
				return "0";
			else return response()->json($propietario);
		}
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
		
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        $propietario = Propietario::find($id);
		if(!$propietario){
			return "0";
		}else{
			$newData = $request->all();
			$propietario->update($newData);
			return response()->json($propietario);
		}
    }
    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $propietario = Propietario::find($id);
		$propietario->delete();
		return response()->json(null);
    }
}
