<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="٫ӆߗ޶" prop="diameter">
      <el-input v-model="dataForm.diameter" placeholder="٫ӆߗ޶"></el-input>
    </el-form-item>
    <el-form-item label="鍒跺瓟涓昏酱杞₿" prop="rotvel1">
      <el-input v-model="dataForm.rotvel1" placeholder="鍒跺瓟涓昏酱杞₿"></el-input>
    </el-form-item>
    <el-form-item label="鍒跺瓟杩涚粰閫熷宿" prop="vel1">
      <el-input v-model="dataForm.vel1" placeholder="鍒跺瓟杩涚粰閫熷宿"></el-input>
    </el-form-item>
    <el-form-item label="" prop="rotvel2">
      <el-input v-model="dataForm.rotvel2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vel2">
      <el-input v-model="dataForm.vel2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="rotvel3">
      <el-input v-model="dataForm.rotvel3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="vel3">
      <el-input v-model="dataForm.vel3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="socketrotvel">
      <el-input v-model="dataForm.socketrotvel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="socketvel">
      <el-input v-model="dataForm.socketvel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="快进速度" prop="fastvel">
      <el-input v-model="dataForm.fastvel" placeholder="快进速度"></el-input>
    </el-form-item>
    <el-form-item label="制孔深度" prop="deep">
      <el-input v-model="dataForm.deep" placeholder="制孔深度"></el-input>
    </el-form-item>
    <el-form-item label="ݴٌܾ Ѝ" prop="fastentype">
      <el-input v-model="dataForm.fastentype" placeholder="ݴٌܾ Ѝ"></el-input>
    </el-form-item>
    <el-form-item label="压脚压力" prop="press">
      <el-input v-model="dataForm.press" placeholder="压脚压力"></el-input>
    </el-form-item>
    <el-form-item label="̡ǰ" prop="advance">
      <el-input v-model="dataForm.advance" placeholder="̡ǰ"></el-input>
    </el-form-item>
    <el-form-item label="" prop="toolname">
      <el-input v-model="dataForm.toolname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="remark0">
      <el-input v-model="dataForm.remark0" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          diameter: '',
          rotvel1: '',
          vel1: '',
          rotvel2: '',
          vel2: '',
          rotvel3: '',
          vel3: '',
          socketrotvel: '',
          socketvel: '',
          fastvel: '',
          deep: '',
          fastentype: '',
          press: '',
          advance: '',
          toolname: '',
          remark0: '',
          time: ''
        },
        dataRule: {
          diameter: [
            { required: true, message: '٫ӆߗ޶不能为空', trigger: 'blur' }
          ],
          rotvel1: [
            { required: true, message: '鍒跺瓟涓昏酱杞₿不能为空', trigger: 'blur' }
          ],
          vel1: [
            { required: true, message: '鍒跺瓟杩涚粰閫熷宿不能为空', trigger: 'blur' }
          ],
          rotvel2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vel2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          rotvel3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          vel3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          socketrotvel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          socketvel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fastvel: [
            { required: true, message: '快进速度不能为空', trigger: 'blur' }
          ],
          deep: [
            { required: true, message: '制孔深度不能为空', trigger: 'blur' }
          ],
          fastentype: [
            { required: true, message: 'ݴٌܾ Ѝ不能为空', trigger: 'blur' }
          ],
          press: [
            { required: true, message: '压脚压力不能为空', trigger: 'blur' }
          ],
          advance: [
            { required: true, message: '̡ǰ不能为空', trigger: 'blur' }
          ],
          toolname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          remark0: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/drillprocess/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.diameter = data.drillprocess.diameter
                this.dataForm.rotvel1 = data.drillprocess.rotvel1
                this.dataForm.vel1 = data.drillprocess.vel1
                this.dataForm.rotvel2 = data.drillprocess.rotvel2
                this.dataForm.vel2 = data.drillprocess.vel2
                this.dataForm.rotvel3 = data.drillprocess.rotvel3
                this.dataForm.vel3 = data.drillprocess.vel3
                this.dataForm.socketrotvel = data.drillprocess.socketrotvel
                this.dataForm.socketvel = data.drillprocess.socketvel
                this.dataForm.fastvel = data.drillprocess.fastvel
                this.dataForm.deep = data.drillprocess.deep
                this.dataForm.fastentype = data.drillprocess.fastentype
                this.dataForm.press = data.drillprocess.press
                this.dataForm.advance = data.drillprocess.advance
                this.dataForm.toolname = data.drillprocess.toolname
                this.dataForm.remark0 = data.drillprocess.remark0
                this.dataForm.time = data.drillprocess.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/drillprocess/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'diameter': this.dataForm.diameter,
                'rotvel1': this.dataForm.rotvel1,
                'vel1': this.dataForm.vel1,
                'rotvel2': this.dataForm.rotvel2,
                'vel2': this.dataForm.vel2,
                'rotvel3': this.dataForm.rotvel3,
                'vel3': this.dataForm.vel3,
                'socketrotvel': this.dataForm.socketrotvel,
                'socketvel': this.dataForm.socketvel,
                'fastvel': this.dataForm.fastvel,
                'deep': this.dataForm.deep,
                'fastentype': this.dataForm.fastentype,
                'press': this.dataForm.press,
                'advance': this.dataForm.advance,
                'toolname': this.dataForm.toolname,
                'remark0': this.dataForm.remark0,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
