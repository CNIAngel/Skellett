package com.gmail.thelimeglass.Feudal;

import javax.annotation.Nullable;

import org.bukkit.Location;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import us.forseth11.feudal.core.Feudal;
import us.forseth11.feudal.kingdoms.Kingdom;
import us.forseth11.feudal.kingdoms.Land;

public class ExprFeudalLocationKingdom extends SimpleExpression<Kingdom>{
	
	//Feudal kingdom at [location] %location%
	
	Feudal feudal = Feudal.getPlugin();
	private Expression<Location> location;
	@Override
	public Class<? extends Kingdom> getReturnType() {
		return Kingdom.class;
	}
	@Override
	public boolean isSingle() {
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] e, int arg1, Kleenean arg2, ParseResult arg3) {
		location = (Expression<Location>) e[0];
		return true;
	}
	@Override
	public String toString(@Nullable Event e, boolean arg1) {
		return "Feudal kingdom name at [location] %location%";
	}
	@Override
	@Nullable
	protected Kingdom[] get(Event e) {
		Land land = new Land(location.getSingle(e));
		if (Feudal.getLandKingdom(land) != null) {
			return new Kingdom[]{Feudal.getLandKingdom(land)};
		} else {
			return null;
		}
	}
}