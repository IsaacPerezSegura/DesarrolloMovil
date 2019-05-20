<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Laptop extends Model
{
    //
	protected $fillable = ['marca,modelo,idPropietario'];
	protected $table = 'laptop';
	
	public function propietario(){
		return $this->belongsTo('App/Propietario','idPropietario');
	}
}
