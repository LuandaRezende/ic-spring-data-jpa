package guru.springframework.controllers;


import guru.springframework.commands.UsuarioForm;
import guru.springframework.converters.UsuarioToUsuarioForm;
import guru.springframework.domain.Usuario;
import guru.springframework.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class UsuarioController {
    private UsuarioService usuarioService;

    private UsuarioToUsuarioForm usuarioToUsuarioForm;

    @Autowired
    public void setUsuarioToUsuarioForm(UsuarioToUsuarioForm usuarioToUsuarioForm) {
        this.usuarioToUsuarioForm = usuarioToUsuarioForm;
    }

    @Autowired
    public void setProductService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/usuario/list";
    }

    @RequestMapping({"/usuario/list", "/usuario"})
    public String listUsuarios(Model model){
        model.addAttribute("usuarios", usuarioService.listAll());
        return "usuario/list";
    }

    @RequestMapping("/usuario/show/{id}")
    public String getUsuario(@PathVariable String id, Model model){
        model.addAttribute("usuario", usuarioService.getById(Long.valueOf(id)));
        return "usuario/show";
    }

    @RequestMapping("usuario/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Usuario usuario = usuarioService.getById(Long.valueOf(id));
        UsuarioForm usuarioForm = usuarioToUsuarioForm.convert(usuario);

        model.addAttribute("usuarioForm", usuarioForm);
        return "usuario/productform";
    }

    @RequestMapping("/usuario/new")
    public String newUsuario(Model model){
        model.addAttribute("usuarioForm", new UsuarioForm());
        return "usuario/usuarioform";
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public String saveOrUpdateUsuario(@Valid UsuarioForm usuarioForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "usuario/usuarioform";
        }

        Usuario savedUsuario = usuarioService.saveOrUpdateUsuarioForm(usuarioForm);

        return "redirect:/usuario/show/" + savedUsuario.getId();
    }

    @RequestMapping("/usuario/delete/{id}")
    public String delete(@PathVariable String id){
        usuarioService.delete(Long.valueOf(id));
        return "redirect:/usuario/list";
    }
}
