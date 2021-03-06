package com.taobao.luaview.fun.binder.ui;

import com.taobao.luaview.fun.base.BaseFunctionBinder;
import com.taobao.luaview.fun.base.BaseVarArgCreator;
import com.taobao.luaview.fun.mapper.ui.UIAnimationMethodMapper;
import com.taobao.luaview.userdata.ui.UDAnimation;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.LibFunction;

/**
 * 动画 （使用Animator，废弃）
 *
 * @author song
 * @date 15/9/2
 */
@Deprecated
public class UIAnimationBinder extends BaseFunctionBinder {

    public UIAnimationBinder() {
        super("Animate");
    }

    @Override
    public Class<? extends LibFunction> getMapperClass() {
        return UIAnimationMethodMapper.class;
    }

    @Override
    public LuaValue createCreator(LuaValue env, final LuaValue metaTable) {
        return new BaseVarArgCreator(env.checkglobals(), metaTable) {
            @Override
            public LuaValue createUserdata(Globals globals, LuaValue metaTable, Varargs varargs) {
                return new UDAnimation(globals, metaTable, varargs);
            }
        };
    }
}
